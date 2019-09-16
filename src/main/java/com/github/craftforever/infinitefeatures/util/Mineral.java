package com.github.craftforever.infinitefeatures.util;

import static com.github.craftforever.infinitefeatures.helpers.RandomHelper.getRandomIntInRange;

import java.awt.Color;

import net.minecraft.item.Item;

public class Mineral
{
	public String name;
	public Color color;
	public Item dropitem;
	public int quality;
	public int genmaxy;
	public int gensize;
	public int genrarity;
	//smaller is rarer

	public Mineral(String iname, Color icolor,int iquality)
	{
		name = iname;
		color = icolor;
		quality = iquality;
		genmaxy = getRandomIntInRange(50/iquality,80/iquality);
		gensize = getRandomIntInRange(5,10)/iquality;
		genrarity = getRandomIntInRange(25,50)/iquality;
		/*
		System.out.print("\n\n"+name+": "+quality+"\n");
		System.out.print("genmaxy : "+genmaxy+"\n");
		System.out.print("gensize : "+gensize+"\n");
		System.out.print("genrarity : "+genrarity+"\n");
		*/
	}
	
}