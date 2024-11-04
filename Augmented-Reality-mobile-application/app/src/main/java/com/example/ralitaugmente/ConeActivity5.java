package com.example.ralitaugmente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;

public class ConeActivity5 extends AppCompatActivity {

    private ArFragment arFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone5);



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
                createCone(anchorNode);
            }
        });
    }


    private void createCone(AnchorNode anchorNode) {
        MaterialFactory.makeOpaqueWithColor(this, new Color(android.graphics.Color.GREEN))
                .thenAccept(material -> {
                    Node coneNode = new Node();
                    coneNode.setParent(anchorNode);

                    float coneHeight = 0.2f;
                    float cylinderRadius = 0.05f;

                    // Création du cylindre pour la partie inférieure du cône
                    Node cylinderNode = new Node();
                    cylinderNode.setParent(coneNode);
                    cylinderNode.setRenderable(ShapeFactory.makeCylinder(
                            cylinderRadius, 0, new Vector3(0, 0, 0), material)
                    );

                    // Création de la sphère pour la partie supérieure du cône
                    Node sphereNode = new Node();
                    sphereNode.setParent(coneNode);
                    sphereNode.setLocalPosition(new Vector3(0, coneHeight / 2.0f, 0));
                    sphereNode.setRenderable(ShapeFactory.makeSphere(
                            cylinderRadius, new Vector3(0, 0, 0), material)
                    );
                });
    }
    }



