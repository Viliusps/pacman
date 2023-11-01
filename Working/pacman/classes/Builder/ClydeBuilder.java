/**
 * @(#) ClydeBuilder.java
 */

package pacman.classes.Builder;

import pacman.classes.AbstractFactory.FastClyde;
import pacman.classes.AbstractFactory.SlowClyde;
import pacman.classes.Clyde;

import javax.swing.*;
import java.awt.*;

public class ClydeBuilder
{
	private final Image orangeColor = new ImageIcon("./Working/images/orange.gif").getImage();

	public Clyde startFastClyde()
	{
		return new ClydeConfigurator(new FastClyde()).addX(96).addY(96).addDx(1).addDy(0).addSpeed(4).addColor(orangeColor).build();
	}
	
	public Clyde startSlowClyde()
	{
		return new ClydeConfigurator(new SlowClyde()).addX(96).addY(96).addDx(1).addDy(0).addSpeed(2).addColor(orangeColor).build();
	}
	
	
}
