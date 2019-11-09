package tree.radblacktree;

public enum  ColorEnum {

    RED_NODE(0),
    BLACK_NODE(1);

    private int colorCode;
    ColorEnum(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }
}
