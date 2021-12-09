package pojo;

public class OverView {
    private String styleName;
    private String imageUri;

    public OverView() {
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public String toString() {
        return "OverView{" +
                "styleName='" + styleName + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
