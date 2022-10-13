import java.io.*;

public class main {
	public static int[][] lireImagePgm(String nom, int lx, int ly) throws IOException {

		String filePath = nom;
		FileInputStream fileInputStream = new FileInputStream(filePath);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

		int[][] data2D = new int[lx][ly];
		String[] headers = new String[4];
		for (int ligne = 0; ligne < 4; ligne++) {
			headers[ligne] = bufferedReader.readLine();
			System.out.println(headers[ligne]);
		}
		for (int ligne = 4; ligne < ly; ligne++) {

			for (int col = 0; col < lx; col++) {

				data2D[ligne][col] = bufferedReader.read();
				System.out.print(data2D[ligne][col] + " ");
			}
			System.out.println();

		}

		fileInputStream.close();
		return data2D;

	}

	public static void ecrireImagePgm(String nom, int[][] mat, int lx, int ly) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(nom));

		for (int i = 0; i < ly; i++) {
			for (int j = 0; j < lx; j++) {
				if (j == lx - 1) {
					bw.write(mat[i][j]);
				} else {
					bw.write(mat[i][j] + ",");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

	public static double moyenneImagePgm(int[][] image) {
		int pixels = 255 * 255;
		double moyenne = 0;
		for (int ligne = 0; ligne < 255; ligne++) {

			for (int col = 0; col < 255; col++) {
				moyenne += image[ligne][col];
			}
		}
		return moyenne / pixels;

	}

	public static double ecartTypeImagePgm(int[][] image, double moyenne) {
		int pixels = 255 * 255;
		double ecartType = 0;
		for (int ligne = 0; ligne < 255; ligne++) {

			for (int col = 0; col < 255; col++) {
				ecartType += (image[ligne][col] - moyenne) * (image[ligne][col] - moyenne);
			}
		}

		return Math.sqrt(ecartType / pixels);

	}

	public static void main(String[] args) throws IOException {
		String nom = "C:\\Users\\meriem\\eclipse-workspace\\TraitementImage\\src\\chat.pgm";

		try {

			int[][] image = lireImagePgm(nom, 255, 255);
			ecrireImagePgm("C:\\Users\\meriem\\eclipse-workspace\\TraitementImage\\src\\chat1.pgm", image, 255, 255);
			double moyenne = moyenneImagePgm(image);
			double ecartType = ecartTypeImagePgm(image, moyenne);
			System.out.println("La moyenne de cette image = " + moyenne);
			System.out.println("L'ecart type de cette image = " + ecartType);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
