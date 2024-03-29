package com.bella.brs.utility;

import java.awt.BorderLayout;

/**
 * @author Bella Baghdasaryan
 */
public class BorderLayoutPositionFactory {
	public static String create(String type){
		if(type != null){
			if(type.toLowerCase() == "north"){
				return BorderLayout.NORTH;
			}else if(type.toLowerCase() == "east"){
				return BorderLayout.EAST;
			}else if(type.toLowerCase() == "south"){
				return BorderLayout.SOUTH;
			}else if(type.toLowerCase() == "west"){
				return BorderLayout.WEST;
			}else if(type.toLowerCase() == "center"){
				return BorderLayout.CENTER;
			}
		}
		return null;
	}
}
