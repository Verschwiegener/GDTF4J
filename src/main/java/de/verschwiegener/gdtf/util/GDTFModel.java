package de.verschwiegener.gdtf.util;

import java.io.File;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import de.verschwiegener.mvr.util.MVRModel.FileType;

public class GDTFModel {

	private final File modelFile;
	private FileType fileType;

	private final Matrix4f matrix;

	/**
	 * Constructor for 3D Model Files
	 * 
	 * @param modelFile
	 * @param transformationMatrix
	 */
	public GDTFModel(File modelFile, Matrix4f transformationMatrix) {
		this.modelFile = modelFile;
		this.matrix = transformationMatrix;
		if (modelFile != null) {
			this.fileType = FileType.fromExtension(modelFile.getName()
					.substring(modelFile.getName().lastIndexOf(".") + 1, modelFile.getName().length()));
			
		}
	}
	/**
	 * Constructor for 2D(SVG) Model Files
	 * 
	 * @param modelFile
	 */
	public GDTFModel(File modelFile) {
		this(modelFile, null);
	}
	
	/**
	 * Returns Matrix for 3D Models, null when fileType is SVG
	 * @return
	 */
	public Matrix4f getMatrix() {
		return matrix;
	}

	public File getModelFile() {
		return modelFile;
	}
	
	public FileType getFileType() {
		return fileType;
	}

	public enum FileType {

		TYPE_3DS(new String[] { "3ds" }), TYPE_GLTF(new String[] { "gltf", "glb" }), TYPE_SVG(new String[] {"svg"});

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
