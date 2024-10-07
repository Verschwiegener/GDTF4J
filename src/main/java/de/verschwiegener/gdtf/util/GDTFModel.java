package de.verschwiegener.gdtf.util;

import java.io.File;

public class GDTFModel {

	private File modelFile;
	private FileType fileType;

	private GDTFMatrix transformationMatrix;

	public GDTFModel(File modelFile, GDTFMatrix transformationMatrix) {
		this.modelFile = modelFile;
		this.transformationMatrix = transformationMatrix;
		if (modelFile != null) {
			this.fileType = FileType.fromExtension(modelFile.getName()
					.substring(modelFile.getName().lastIndexOf(".") + 1, modelFile.getName().length()));
			if (fileType == FileType.TYPE_3DS) {
				//transformationMatrix.setRotationXYZ(new double[] { Math.toRadians(-90f), 0, 0 });
			}
		}
	}

	public GDTFMatrix getTransformationMatrix() {
		return transformationMatrix;
	}
	
	public void setTransformationMatrix(GDTFMatrix transformationMatrix) {
		this.transformationMatrix = transformationMatrix;
	}

	public File getModelFile() {
		return modelFile;
	}

	public enum FileType {

		TYPE_3DS(new String[] { "3ds" }), TYPE_GLTF(new String[] { "gltf", "glb" });

		private final String[] extension;

		FileType(String[] extension) {
			this.extension = extension;
		}

		public String[] getFileExtension() {
			return extension;
		}

		public static FileType fromExtension(String extension) {
			for (FileType type : FileType.values()) {
				for (String fExtension : type.getFileExtension()) {
					if (fExtension.equals(extension))
						return type;
				}
			}
			return null;
		}

	}
}
