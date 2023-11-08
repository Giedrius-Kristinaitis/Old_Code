package com.gasis.outlineracing.logic.world.vechile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;
import com.badlogic.gdx.physics.box2d.joints.WheelJointDef;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.storage.PrefStorage;

public class Vechile {
   private float ACCELERATION;
   private float BODY_WEIGHT;
   private final float CHASIS_HEIGHT = 0.75F;
   private final float CHASIS_WIDTH = 1.5F;
   private float SUSPENSION;
   private float TIRES;
   private float TOP_SPEED;
   private final float WHEEL_RADIUS = 0.4F;
   private Wheel back;
   private WheelJoint backJoint;
   private Chasis chasis;
   private boolean enabledByLeft = false;
   private Wheel front;
   private WheelJoint frontJoint;
   private int league;
   private World world;

   public Vechile(World var1, Assets var2, int var3, PrefStorage var4) {
      this.world = var1;
      this.league = var3;
      this.loadUpgrades(var4);
      this.chasis = new Chasis();
      this.chasis.setup(var3, var2);
      this.back = new Wheel();
      this.back.setup(var3, var2);
      this.front = new Wheel();
      this.front.setup(var3, var2);
      this.init();
   }

   private void createJoints() {
      WheelJointDef var1 = new WheelJointDef();
      var1.enableMotor = false;
      var1.maxMotorTorque = this.ACCELERATION;
      var1.motorSpeed = this.TOP_SPEED;
      var1.localAxisA.set(0.0F, 1.0F);
      var1.frequencyHz = this.SUSPENSION;
      var1.bodyA = this.chasis.getBody();
      var1.bodyB = this.back.getBody();
      var1.collideConnected = false;
      var1.localAnchorA.set(-0.75F, -0.375F);
      this.backJoint = (WheelJoint)this.world.createJoint(var1);
      var1.bodyB = this.front.getBody();
      var1.localAnchorA.set(0.75F, -0.375F);
      this.frontJoint = (WheelJoint)this.world.createJoint(var1);
   }

   private void init() {
      this.chasis.createBody(this.league, this.world, 3.0F, 4.0F, 1.5F, 0.75F, 1.0F, 0.0F, this.BODY_WEIGHT);
      this.front.createBody(this.world, 3.0F, 4.0F, 0.4F, this.TIRES, 0.5F);
      this.back.createBody(this.world, 3.0F, 4.0F, 0.4F, this.TIRES, 0.5F);
      this.createJoints();
   }

   private void loadUpgrades(PrefStorage var1) {
      int var6 = var1.getInt("top_speed");
      int var2 = var1.getInt("acceleration");
      int var3 = var1.getInt("suspension");
      int var4 = var1.getInt("lighter_body");
      int var5 = var1.getInt("tires");
      Upgrades var7 = new Upgrades();
      this.TOP_SPEED = var7.getTopSpeed(var6);
      this.ACCELERATION = var7.getAcceleration(var2);
      this.SUSPENSION = var7.getSuspension(var3);
      this.BODY_WEIGHT = var7.getLB(var4);
      this.TIRES = var7.getTires(var5);
   }

   public void disableMotor(boolean var1) {
      if (var1) {
         if (this.enabledByLeft) {
            this.backJoint.enableMotor(false);
            this.frontJoint.enableMotor(false);
         }
      } else if (!this.enabledByLeft) {
         this.backJoint.enableMotor(false);
         this.frontJoint.enableMotor(false);
      }

   }

   public void enableMotor(boolean var1) {
      if (var1) {
         this.backJoint.setMotorSpeed(this.TOP_SPEED);
         this.frontJoint.setMotorSpeed(this.TOP_SPEED);
         this.enabledByLeft = true;
      } else {
         this.backJoint.setMotorSpeed(-this.TOP_SPEED);
         this.frontJoint.setMotorSpeed(-this.TOP_SPEED);
         this.enabledByLeft = false;
      }

      this.backJoint.enableMotor(true);
      this.frontJoint.enableMotor(true);
   }

   public Body getBody() {
      return this.chasis.getBody();
   }

   public float getX() {
      return this.chasis.getBody().getPosition().x * 100.0F;
   }

   public float getY() {
      return this.chasis.getBody().getPosition().y * 100.0F;
   }

   public void render(SpriteBatch var1, float var2) {
      this.chasis.render(var1, var2);
      this.front.render(var1, var2);
      this.back.render(var1, var2);
   }
}
