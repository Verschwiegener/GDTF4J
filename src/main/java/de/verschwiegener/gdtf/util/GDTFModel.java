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
				transformationMatrix.setRotationXYZ(new double[] { Math.toRadians(-90f), 0, 0 });
			}
		}
	}

	public GDTFMatrix getTransformationMatrix() {
		return transformationMatrix;
	}

	public File getModelFile() {
		return modelFile;
	}

	/**
	 * Transforms matrix Scale/Rotation/Position with given Matrix
	 * 
	 * @param other          Matrix to transform with
	 * @param ignoreScaling  Whether or not to ignore Scaling
	 * @param ignoreRotation Whether or not to ignore Rotation
	 * 
	 * 
	 *                       The Layer object should have only a elevation and
	 *                       nothing else
	 * 
	 *                       A Geometry or a Symbol do not have any restriction on
	 *                       their matrix
	 * 
	 *                       All other object (Projector, Fixture, Truss, Scene
	 *                       Object, ...) have only a rotation and offset, but no
	 *                       scale.
	 * 
	 * 
	 */
	public void transform(GDTFMatrix other, boolean ignoreScaling, boolean ignoreRotation) {
		//Transform Scaling
		if (!ignoreScaling) {
			transformationMatrix.mulScale(other.getScale());
		}
		//Transform Rotation
		if (!ignoreRotation) {
			transformationMatrix.offsetRotation(other.getRotationAngles());
			
			
			/*double[] otherRotation = other.getRotationAngles();
			double[] thisRotation = transformationMatrix.getRotationAngles();
			
			/* transformationMatrix.setRotationXYZ(new double[] { otherRotation[0] + thisRotation[0],
					otherRotation[1] + thisRotation[1],
					otherRotation[2] + thisRotation[2] });
			 */

			/*transformationMatrix.setRotationXYZ(new double[] { Math.toRadians(otherRotation[0] + thisRotation[0]),
					Math.toRadians(otherRotation[1] + thisRotation[1]),
					Math.toRadians(otherRotation[2] + thisRotation[2]) });*/

		}

		transformationMatrix.translate(other.getTranslation());
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
