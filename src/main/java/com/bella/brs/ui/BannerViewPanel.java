package com.bella.brs.ui;

import java.awt.BorderLayout;

import com.bella.brs.utility.ViewComponentFactory;
import com.bella.brs.utility.constants.ResourcePaths;

/**
 * @author Bella Baghdasaryan
 */
@SuppressWarnings("serial")
public class BannerViewPanel extends BaseView implements View{
	public BannerViewPanel(){
		this.setLayout(new BorderLayout());
		this.add(ViewComponentFactory.createJLabelImage(ResourcePaths.BANNER));
	}
}
