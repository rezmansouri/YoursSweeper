
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprites {

    BufferedImage house_idle_png = null;
    static ImageIcon house_idle_ico = null;
    BufferedImage house_hover_png = null;
    static ImageIcon house_hover_ico = null;
    BufferedImage house_empty_png = null;
    static ImageIcon house_empty_ico = null;
    BufferedImage number_1_png = null;
    static ImageIcon number_1_ico = null;
    BufferedImage number_2_png = null;
    static ImageIcon number_2_ico = null;
    BufferedImage number_3_png = null;
    static ImageIcon number_3_ico = null;
    BufferedImage number_4_png = null;
    static ImageIcon number_4_ico = null;
    BufferedImage number_5_png = null;
    static ImageIcon number_5_ico = null;
    BufferedImage number_6_png = null;
    static ImageIcon number_6_ico = null;
    BufferedImage number_7_png = null;
    static ImageIcon number_7_ico = null;
    BufferedImage number_8_png = null;
    static ImageIcon number_8_ico = null;
    BufferedImage flag_idle_png = null;
    static ImageIcon flag_idle_ico = null;
    BufferedImage flag_hover_png = null;
    static ImageIcon flag_hover_ico = null;
    BufferedImage question_idle_png = null;
    static ImageIcon question_idle_ico = null;
    BufferedImage question_hover_png = null;
    static ImageIcon question_hover_ico = null;
    BufferedImage misclicked_bomb_png = null;
    static ImageIcon misclicked_bomb_ico = null;
    BufferedImage unflagged_bomb_png = null;
    static ImageIcon unflagged_bomb_ico = null;
    BufferedImage flagged_bomb_png = null;
    static ImageIcon flagged_bomb_ico = null;
    BufferedImage flagged_number_png=null;
    static ImageIcon flagged_number_ico=null;

    void init() {
        try {
            house_idle_png = ImageIO.read(getClass().getResource("/sprites/house_idle.png"));
            house_idle_ico = new ImageIcon(house_idle_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            house_hover_png = ImageIO.read(getClass().getResource("/sprites/house_hover.png"));
            house_hover_ico = new ImageIcon(house_hover_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            house_empty_png = ImageIO.read(getClass().getResource("/sprites/house_empty.png"));
            house_empty_ico = new ImageIcon(house_empty_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_1_png = ImageIO.read(getClass().getResource("/sprites/number_1.png"));
            number_1_ico = new ImageIcon(number_1_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_2_png = ImageIO.read(getClass().getResource("/sprites/number_2.png"));
            number_2_ico = new ImageIcon(number_2_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_3_png = ImageIO.read(getClass().getResource("/sprites/number_3.png"));
            number_3_ico = new ImageIcon(number_3_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_4_png = ImageIO.read(getClass().getResource("/sprites/number_4.png"));
            number_4_ico = new ImageIcon(number_4_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_5_png = ImageIO.read(getClass().getResource("/sprites/number_5.png"));
            number_5_ico = new ImageIcon(number_5_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_6_png = ImageIO.read(getClass().getResource("/sprites/number_6.png"));
            number_6_ico = new ImageIcon(number_6_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_7_png = ImageIO.read(getClass().getResource("/sprites/number_7.png"));
            number_7_ico = new ImageIcon(number_7_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            number_8_png = ImageIO.read(getClass().getResource("/sprites/number_8.png"));
            number_8_ico = new ImageIcon(number_8_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            flag_idle_png = ImageIO.read(getClass().getResource("/sprites/flag_idle.png"));
            flag_idle_ico = new ImageIcon(flag_idle_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            flag_hover_png = ImageIO.read(getClass().getResource("/sprites/flag_hover.png"));
            flag_hover_ico = new ImageIcon(flag_hover_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            question_idle_png = ImageIO.read(getClass().getResource("/sprites/question_mark_idle.png"));
            question_idle_ico = new ImageIcon(question_idle_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            question_hover_png = ImageIO.read(getClass().getResource("/sprites/question_mark_hover.png"));
            question_hover_ico = new ImageIcon(question_hover_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            misclicked_bomb_png = ImageIO.read(getClass().getResource("/sprites/misclicked_bomb.png"));
            misclicked_bomb_ico = new ImageIcon(misclicked_bomb_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            unflagged_bomb_png = ImageIO.read(getClass().getResource("/sprites/unflagged_bomb.png"));
            unflagged_bomb_ico = new ImageIcon(unflagged_bomb_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            flagged_bomb_png = ImageIO.read(getClass().getResource("/sprites/flagged_bomb.png"));
            flagged_bomb_ico = new ImageIcon(flagged_bomb_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            flagged_number_png = ImageIO.read(getClass().getResource("/sprites/flagged_number.png"));
            flagged_number_ico = new ImageIcon(flagged_number_png.getScaledInstance(81, 81, Image.SCALE_SMOOTH));
            
        } catch (Exception ex) {

        }
    }
}
