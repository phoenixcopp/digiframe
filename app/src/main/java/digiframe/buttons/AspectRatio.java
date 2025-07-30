package digiframe.buttons;

public class AspectRatio {
    int width;
    int height;

    public AspectRatio(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getRatio() {
        return (double) width / height;
    }
}
