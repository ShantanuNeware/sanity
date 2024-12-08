package com.utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageComparison {

	public static void compareImages(File base, File toCompare, String result) throws IOException {
		BufferedImage baseImage = ImageIO.read(base);
		BufferedImage toCompareImage = ImageIO.read(toCompare);
		int height = baseImage.getHeight();
		int width = baseImage.getWidth();

		BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				try {
					int pixelOfToCompareImage = toCompareImage.getRGB(w, h);
					int pixelOfBaseImage = baseImage.getRGB(w, h);
					if (pixelOfBaseImage == pixelOfToCompareImage) {
						resultImage.setRGB(w, h, pixelOfBaseImage);
					} else {

						int a = 0xff | pixelOfBaseImage >> 24, r = 0xff & pixelOfBaseImage >> 16,
								g = 0x00 & pixelOfBaseImage >> 8, b = 0x00 & pixelOfBaseImage;

						int updatedRGB = a << 24 | r << 16 | g << 8 | b;
						resultImage.setRGB(w, h, updatedRGB);
					}

				} catch (Exception e) {
					resultImage.setRGB(w, h, 0x80ff0000);
				}
			}
		}

		ImageIO.write(resultImage, "png", new File(result));
	}
}