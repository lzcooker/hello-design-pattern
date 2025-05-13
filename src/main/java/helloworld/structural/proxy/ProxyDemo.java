package helloworld.structural.proxy;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author luzhicheng
 * @date 2025/5/12 15:27
 */
public class ProxyDemo {
    public static void main(String[] args) throws MalformedURLException {
        String image = "http://image.jpg";
        URL url = new URL(image);
        HighResolutionImage highResolutionImage = new HighResolutionImage(url);
        ImageProxy imageProxy = new ImageProxy(highResolutionImage);
        imageProxy.showImage();
    }
}
interface Image {
    void showImage();
}
class HighResolutionImage implements Image {
    private URL imageURL;
    private long startTime;
    private int height;
    private int width;
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public HighResolutionImage(URL imageURL) {
        this.imageURL = imageURL;
        this.startTime = System.currentTimeMillis();
        this.width = 600;
        this.height = 600;
    }
    public boolean isLoad() {
// 模拟图片加载，延迟 3s 加载完成
        long endTime = System.currentTimeMillis();
        return endTime - startTime > 3000;
    }
    @Override
    public void showImage() {
        System.out.println("Real Image: " + imageURL);
    }
}

class ImageProxy implements Image {
    private HighResolutionImage highResolutionImage;
    public ImageProxy(HighResolutionImage highResolutionImage) {
        this.highResolutionImage = highResolutionImage;
    }
    @Override
    public void showImage() {
        while (!highResolutionImage.isLoad()) {
            try {
                System.out.println("Temp Image: " + highResolutionImage.getWidth() + " " +
                        highResolutionImage.getHeight());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        highResolutionImage.showImage();
    }
}
