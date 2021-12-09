package io.github.wpinrui.gameday.storage;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.Objects;

import io.github.wpinrui.gameday.model.Model;

public class Storage {

    public static void readSave(CallBack callBack) throws IOException, ClassNotFoundException {
        String uid = FirebaseAuth.getInstance().getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        assert uid != null;
        db.collection("users").document(uid).get().addOnCompleteListener(
                task -> callBack.onCallBack(
                        Objects.requireNonNull(task.getResult()).toObject(Model.class)));
    }

    public static void writeSave(Model model) throws IOException {
        String uid = FirebaseAuth.getInstance().getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        assert uid != null;
        db.collection("users").document(uid).set(model);
    }

    public interface CallBack {
        void onCallBack(Model m);
    }
}
