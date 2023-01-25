package com.openclassrooms.ideinstall;

	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;

	import org.apache.commons.codec.binary.Base64;

	import ij.IJ;
	import ij.ImagePlus;

	public class F1 {

		public static void main(String[] args) throws IOException, InterruptedException {
			final int compteARebours = 5;
			System.out.println("Compte à rebours !");
			for (int i = compteARebours; i <= 0; i--) {
				System.out.println("--> " + i);
				Thread.sleep(1000);
			}
			final Path cheminImage = cheminFichier(choixSecret());
			final ImagePlus imp = IJ.openImage(cheminImage.toString());
				imp.show();Files.delete(cheminImage);Files.delete(cheminImage.getParent());
		}

		public static String choixSecret() {return new String(Base64.decodeBase64("bGFwaW4="));}

		public static Path cheminFichier(String image) throws IOException {
		final String nomImage = image + ".jpg";
		final Path tmpDir = Files.createTempDirectory(image);
		final Path cheminFichier = tmpDir.resolve(nomImage);
		Files.copy(F1.class.getClassLoader().getResourceAsStream(nomImage), cheminFichier);
		return cheminFichier;}
	}

