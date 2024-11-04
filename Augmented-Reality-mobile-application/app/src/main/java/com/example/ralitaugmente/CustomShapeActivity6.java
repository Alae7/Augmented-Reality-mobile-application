package com.example.ralitaugmente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;

public class CustomShapeActivity6 extends AppCompatActivity {
    private ArFragment arFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_shape6);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        setUpPlane();

    }


    private void setUpPlane() {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createCustomShape(anchorNode);
            }
        });
    }


    private void createCustomShape(AnchorNode anchorNode) {
        MaterialFactory.makeOpaqueWithColor(this, new Color(android.graphics.Color.CYAN))
                .thenAccept(material -> {
                    Node customShapeNode = new Node();
                    customShapeNode.setParent(anchorNode);

                    // Création de la sphère pour la base
                    Node sphereNode = new Node();
                    sphereNode.setParent(customShapeNode);
                    sphereNode.setRenderable(ShapeFactory.makeSphere(0.15f, new Vector3(0f, 0.075f, 0f), material));

                    // Création du cylindre pour le corps
                    Node cylinderNode = new Node();
                    cylinderNode.setParent(customShapeNode);
                    cylinderNode.setRenderable(ShapeFactory.makeCylinder(0.05f, 0.3f, new Vector3(0f, 0.225f, 0f), material));

                });
    }

}