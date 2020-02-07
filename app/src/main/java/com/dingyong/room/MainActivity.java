package com.dingyong.room;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dingyong.room.DataRepository.DataRepository;
import com.dingyong.room.entity.Address;
import com.dingyong.room.entity.ClassStu;
import com.dingyong.room.entity.Playlist;
import com.dingyong.room.entity.PlaylistSongJoin;
import com.dingyong.room.entity.Song;
import com.dingyong.room.entity.Student;
import com.dingyong.room.entity.User;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private static final String TAG = "MainActivity";
    private NameViewModel model;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        myRequetPermission();
        mTextView = findViewById(R.id.text);
        model = new ViewModelProvider(this).get(NameViewModel.class);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextView.setText(s);
            }
        };
        model.getCurrentName().observe(this, observer);

    }

    public void onInsert(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<User> userList = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    User user = new User();
                    user.mUid = i;
                    user.mFirstName = "first" + i;
                    user.mLastName = "laster" + i;
                    Address address = new Address();
                    address.city = "深圳" + i;
                    address.postCode = 518000 + i;
                    address.street = "深圳大道" + i + "号";
                    user.mAddress = address;
                    userList.add(user);
                }
                DataRepository.getInstance(mContext).inser(userList);
            }
        }).start();

    }

    public void onQueryAll(View view) {
        model.getCurrentName().setValue("hello world setValue" );
        new Thread(new Runnable() {
            @Override
            public void run() {
                model.getCurrentName().postValue("hello world postValue");
                List<User> users = DataRepository.getInstance(mContext).getAll();
                if (users != null) {
                    for (User user : users) {
                        Log.d(TAG, "user=" + user.toString());
                    }
                }
            }
        }).start();

    }

    public void onQueryById(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Integer> integers = new ArrayList<>();
                for (int i = 0; i < 6; i++) {
                    integers.add(i);
                }
                List<User> users = DataRepository.getInstance(mContext).loadAllByIds(integers);
                if (users != null) {
                    for (User user : users) {
                        Log.d(TAG, "user=" + user.toString());
                    }
                }
                String where = "mUid = 1";
                List<User> usersList = DataRepository.getInstance(mContext).query(where);
                if (usersList != null) {
                    for (User user : usersList) {
                        Log.d(TAG, "usersList user=" + user.toString());
                    }
                }
            }
        }).start();
    }

    public void onDelete(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = DataRepository.getInstance(mContext).findById(1);
                DataRepository.getInstance(mContext).delete(user);

                List<Integer> integers = new ArrayList<>();
                integers.add(2);
                integers.add(3);
                DataRepository.getInstance(mContext).delete(integers);

                List<User> users = DataRepository.getInstance(mContext).getAll();
                if (users != null) {
                    for (User userData : users) {
                        Log.d(TAG, "user=" + userData.toString());
                    }
                }
            }
        }).start();
    }

    public void onUpdate(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = DataRepository.getInstance(mContext).findById(5);
                user.mLastName = "5";
                user.mFirstName = "5";
                DataRepository.getInstance(mContext).update(user);
                List<User> users = DataRepository.getInstance(mContext).getAll();
                if (users != null) {
                    for (User userData : users) {
                        Log.d(TAG, "user=" + userData.toString());
                    }
                }
            }
        }).start();
    }

    private void myRequetPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            Toast.makeText(this, "您已经申请了权限!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void insertStudent(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Student> students = DataUtils.getStudentList();
                List<ClassStu> classList = DataUtils.getClassList();

                DataRepository.getInstance(mContext).insertClassStu(classList);

                DataRepository.getInstance(mContext).insertStudent(students);


                List<Student> studentsList = DataRepository.getInstance(mContext).queryAllStudent();
                for (Student student : studentsList) {
                    Log.d(TAG, "student = " + student.toString());
                }
                List<ClassStu> classListData = DataRepository.getInstance(mContext).queryAllClass();
                for (ClassStu classStu : classListData) {
                    Log.d(TAG, "classStu = " + classStu.toString());
                }

            }
        }).start();
    }

    public void insertPlaySong(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Song song = new Song();
                song.artistName = "name";
                song.songName = "songName";
                DataRepository.getInstance(mContext).insert(song);


                Playlist playlist = new Playlist();
                playlist.name = "name";
                playlist.description = "description";
                DataRepository.getInstance(mContext).insert(playlist);


                List<Song> songs = DataRepository.getInstance(mContext).getAllSong();
                List<Playlist> playlists = DataRepository.getInstance(mContext).getAllPlayList();

                for (Playlist playlist1 : playlists) {
                    Log.d(TAG, "playlist1=" + playlist1.toString());
                }
                for (Song song1 : songs) {
                    Log.d(TAG, "song1=" + song1.toString());

                    PlaylistSongJoin songJoin = new PlaylistSongJoin();
                    songJoin.playlistId = 1;
                    songJoin.songId = 1;
                    DataRepository.getInstance(mContext).insert(songJoin);


                    DataRepository.getInstance(mContext).getPlaylistsForSong(song1.id);
                }
            }
        }).start();


    }
}
