import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorChecker {
    private String rgbString = "rgb(119, 119, 119)";
    private final String rgbaString = "rgba(119, 119, 119, 1)";


    @Test
        public void ColorCheck() {
        System.out.println(getColorType(rgbString));
        System.out.println(getColorType(rgbaString));
        System.out.println(getColorValue(rgbString));
        System.out.println(getColorValue(rgbaString));
        //Assert.assertTrue(getColorType(rgbString).equals("rgb"));
        System.out.println(colorConverter(rgbString));
        System.out.println(colorConverter(rgbaString));
        Assert.assertTrue(colorConverter(rgbString).equals(colorConverter(rgbaString)));



    }

    private String getColorType(String color) {
        String searchedPattern = "[a-z]*";
        Pattern pattern = Pattern.compile(searchedPattern);
        Matcher matcher = pattern.matcher(color);

        if (matcher.find()) {
            return matcher.group(0);
        }
        else {
            throw new IllegalStateException("Color type not found");
        }
    }

    private List<Integer> getColorValue(String color) {
        String searchedPattern = "([0-9])+";
        Pattern pattern = Pattern.compile(searchedPattern);
        Matcher matcher = pattern.matcher(color);
        List<Integer> colorValues = new ArrayList<>();
        while (matcher.find()) {
            colorValues.add(Integer.valueOf(matcher.group(0)));
        }
        return colorValues;
    }

    private Color colorConverter(String color) {
        String colorType = getColorType(color);
        List<Integer> colorValues = getColorValue(color);
        if (colorType.equals("rgb")) {
            return new Color(colorValues.get(0), colorValues.get(1), colorValues.get(2));
        }
        if (colorType.equals("rgba")) {
            return new Color(colorValues.get(0), colorValues.get(1), colorValues.get(2), colorValues.get(3));
        }
        throw new IllegalArgumentException("e");
    }

}