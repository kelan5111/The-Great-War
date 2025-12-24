package com.thegreatwar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;
import java.util.List;

public class BattleScreen implements Screen {
    private final float ZOOM_IN_LIMIT = 0.5f;
    private final float ZOOM_OUT_LIMIT = 1.5f;

    static OrthographicCamera camera;
    static Stage stage;

    private final MainGame game;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private Trench trench1;
    private Trench trench2;
    private Truck truck1;

    private List<Waypoint> mainWaypoints;

    public BattleScreen(MainGame game) {
        this.game = game;
        //Game mechanics
        this.batch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        //Waypoints
        this.mainWaypoints = new ArrayList<Waypoint>();

        stage = new Stage(new ScreenViewport(camera));

        //Objects drawn
        this.trench1 = new Trench(Faction.CENTRAL_POWER, 100f, game.getHeight());
        this.trench2 = new Trench(Faction.TRIPLE_ENTENTE, game.getWidth() - 125f, game.getHeight());

        // In BattleScreen.java
        this.truck1 = new Truck(100, 300, 25, "Truck.png");
        stage.addActor(this.truck1);
    }


    @Override
    public void show() {
        //Build main waypoints on map
        this.buildMainWaypoints();

        Gdx.input.setInputProcessor(stage);
        stage.setDebugAll(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.310f, 0.260f, 0.260f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float cameraSpeed = 300 * delta; // 300 units per second

        //Move the camera WASD
        if (Gdx.input.isKeyPressed(Input.Keys.W)) camera.position.y += cameraSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) camera.position.y -= cameraSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) camera.position.x -= cameraSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) camera.position.x += cameraSpeed;
        //Manage the zoom Q and E
        this.manageZoom();

        //Update everything
        camera.update();

        //Updating acts
        stage.act(delta);

        //Draw shapes
        this.shapeRenderer.setProjectionMatrix(camera.combined);

        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        this.trench1.draw(this.shapeRenderer);
        this.trench2.draw(this.shapeRenderer);

        this.drawMainWaypoints(true);

        this.shapeRenderer.end();

        stage.draw();
    }

    private void buildMainWaypoints() {
        final int SPREAD = 25;

        for (int everyX = 0; everyX < this.game.getWidth(); everyX += SPREAD) {
            for (int everyY = 0; everyY < this.game.getHeight(); everyY += SPREAD) {
                this.mainWaypoints.add(new Waypoint(everyX, everyY));
            }
        }
    }

    private void drawMainWaypoints(boolean show) {
        for (Waypoint waypoint : this.mainWaypoints) {
            waypoint.draw(this.shapeRenderer);
            if (show) waypoint.show();
        }
    }

    private void manageZoom() {
        float deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.Q) && camera.zoom < ZOOM_OUT_LIMIT) {
            camera.zoom += 1.0f * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E) && camera.zoom > ZOOM_IN_LIMIT) {
            camera.zoom -= 1.0f * deltaTime;
        }

        camera.update();
    }

    static OrthographicCamera getCamera() {
        return camera;
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
