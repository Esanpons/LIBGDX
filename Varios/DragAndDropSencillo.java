
final Image image =new Image(new Texture("imagen.png"));
image.setSize(50,50);
image.addListener(new DragListener(){

	public void drag(InputEvent event, float x, float y, int pointer) {

			image.moveBy(x - image.getWidth() / 2, y - image.getHeight() / 2);
	}
});
stage.addActor(image);