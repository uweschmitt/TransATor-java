package uk.ac.ebi.cheminformatics.pks.generator;

import org.junit.Test;
import uk.ac.ebi.cheminformatics.pks.parser.FeatureParserTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: pmoreno
 * Date: 1/8/13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public class PKStructureImageGeneratorTest {
    @Test
    public void testGenerateStructureImage() throws Exception {
        StructureGenerator generator = new StructureGenerator(FeatureParserTest.class.getResourceAsStream("Cosmidsequence.features"));
        generator.run();
        PKStructure struct = generator.getStructure();

        PKStructureImageGenerator imageGenerator = new PKStructureImageGenerator();
        BufferedImage image = imageGenerator.generateStructureImage(struct, new Dimension(900, 900));

        File outputFile = new File("/tmp/pksCosmidImage.png");
        ImageIO.write(image,"png",outputFile);

    }

    @Test
    public void testGenerateStructureImageOnnamide() throws Exception {
        StructureGenerator generator = new StructureGenerator(FeatureParserTest.class.getResourceAsStream("onnamid.features"));
        generator.run();
        PKStructure struct = generator.getStructure();

        PKStructureImageGenerator imageGenerator = new PKStructureImageGenerator();
        BufferedImage image = imageGenerator.generateStructureImage(struct, new Dimension(900, 900));

        File outputFile = new File("/tmp/pksOnnamideImage.png");
        ImageIO.write(image,"png",outputFile);

    }
}