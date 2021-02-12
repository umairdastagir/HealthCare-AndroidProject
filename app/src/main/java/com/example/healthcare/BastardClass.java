package com.example.healthcare;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.healthcare.Model.AnsweredModelClass;
import com.example.healthcare.Model.Like;
import com.example.healthcare.Model.UserConstantModel;
import com.example.healthcare.Model.UserModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BastardClass {

    public static final String ANSWERED_POST="AnsweredPost";
    public static final String ANSWERED_LIKES="AnsweredLikes";
    public static final String CURRENT_USER = "user";
    static List<AnsweredModelClass> answeredModelClasses=new ArrayList<>();
    static FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
    public static void  setAnsweredPost(String pushKeyOfPost, final Context context, final String doctorName, final String answer){
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference(ANSWERED_POST);
        databaseReference.child(pushKeyOfPost).push().child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String,Object> map=new HashMap<>();
                map.put("doctorUid",UserConstantModel.ImageUri);
                map.put("nameOfDoctor",UserConstantModel.Name);
                map.put("Answer",answer);
                map.put("pushKey",dataSnapshot.getKey());
                map.put("ImageUri",UserConstantModel.ImageUri);

                databaseReference.updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Answered", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void getAnsweredPost(String pushKeyOfPost){
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference(ANSWERED_POST);
        databaseReference.child(pushKeyOfPost).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    AnsweredModelClass answeredModelClass=snapshot.getValue(AnsweredModelClass.class);
                    answeredModelClasses.add(answeredModelClass);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public static void setAnsweredLikes(String pushKeyOfAnswer, final Context mContext){
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference(ANSWERED_LIKES);
        databaseReference.child(pushKeyOfAnswer).child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot != null){
                    Like liked =dataSnapshot.getValue(Like.class);
                    if (liked.isLiked()){
                        dataSnapshot.getRef().removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(mContext, "Disliked", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }else {
                    HashMap<String,Object> map=new HashMap<>();
                    map.put("Liked",true);
                    databaseReference.updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(mContext, "Liked", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(mContext, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }


    public static void GetLikesOfCurrentPostOfCurrentAnswer(String pushKeyOfAnswer, final Context mContext){
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference(ANSWERED_LIKES);
        databaseReference.child(pushKeyOfAnswer).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(mContext, "Likes "+dataSnapshot.getChildrenCount(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(mContext, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
//
//    public static void GetCurrentUserInfo(final Context context){
//        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(CURRENT_USER);
//        databaseReference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot != null){
//                    UserModel userModel=dataSnapshot.getValue(UserModel.class);
//                    UserConstantModel.Name(userModel.getName());
//                    UserConstantModel.Email(userModel.getEmail());
//                    UserConstantModel.Uid(userModel.getUid());
//                    UserConstantModel.ImageUri(userModel.getImageUri());
//                }else {
//                    Toast.makeText(context, "your data did not exist", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
