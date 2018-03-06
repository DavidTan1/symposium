/*******************************************************************************
 * Copyright (c) 2016-2017 Benjamin Nockles
 *
 * This file is part of OrcMath.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License 
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package guiTeacher.components;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;
import maple_gacha.Hero;

public class ClickableCharacter extends Graphic implements Clickable { 

	private Action action;
	private String imageLocation;
	private Hero hero;
	private boolean enable = false;
	private Action hoverAction;
	

	public ClickableCharacter(int x, int y, int w, int h, String imageLocation,Hero hero) {
		super(x, y, w, h, imageLocation);
		this.imageLocation = imageLocation;
		this.hero = hero;
	} 
	public void changebool() {
		enable = !enable;
	}
	public boolean returnbool() {
		return enable;
	}
	public void changeHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return hero;
	}
	
	
	public ClickableCharacter(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
	}

	
	public void setAction(Action a){
		this.action = a;
	}
	public ClickableCharacter(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
	}

	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

	public void act() {
		if(action != null)action.act();
	}
	
	public void hoverAction(){
		if(hoverAction != null)hoverAction.act();
	}
	
	
	public void setHoverAction(Action hoverAction) {
		this.hoverAction = hoverAction;
	}
	
	public String getImageLocation() {
		return this.imageLocation;
	}

}
