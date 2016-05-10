package com.boardgame.game;

import com.badlogic.gdx.InputProcessor;

public class MyInput implements InputProcessor {
	private boolean touchDown, touchUp;

	public MyInput() {
		super();
		this.touchDown = this.touchUp = false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		touchDown = true;
		return false;
	}

	public boolean getTouchDown() {
		return this.touchDown;
	}

	public void setTouchDown(boolean set) {
		this.touchDown = set;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		touchUp = true;
		touchDown = false;
		return false;
	}

	public boolean getTouchUp() {
		return this.touchUp;
	}

	public void setTouchUp(boolean set) {
		this.touchUp = set;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}