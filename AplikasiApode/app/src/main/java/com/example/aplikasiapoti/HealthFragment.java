package com.example.aplikasiapoti;
import butterknife.BindView;
import butterknife.ButterKnife;
import kotlin.collections.ArrayDeque;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aplikasiapoti.api.BayiServiceApi;
import com.example.aplikasiapoti.api.RetrofitClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.theartofdev.edmodo.cropper.CropImage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class HealthFragment extends Fragment {
    private EditText tinggiBadan, beratBadan, lab, lingkarPerut;
    private String setKategoriPos, setNamaPasien, setTinggiBadan, setBeratBadan, setNIK, setTensiDarah,setFoto;
    private DbHealth dbhealth;
    Uri resultUri;

    private Button simpan;
    private Spinner spinner;

    public HealthFragment() {
        // Required empty public constructor
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        tinggiBadan = view.findViewById(R.id.tinggi_badan);
        beratBadan = view.findViewById(R.id.berat_badan);
        lingkarPerut = view.findViewById(R.id.lingkar_perut);
        lab= view.findViewById(R.id.lab);
        simpan = view.findViewById(R.id.buttonKirim);
        spinner = view.findViewById(R.id.dropdown_nik);


        BayiServiceApi bayiServiceApi = RetrofitClient.getInstance().create(BayiServiceApi.class);
        BayiServiceApi serviceApi = bayiServiceApi;
        Call<BayiResponse> responseCall = serviceApi.getDatabayi();
        responseCall.enqueue(new Callback<BayiResponse>() {

            @Override
            public void onResponse(Call<BayiResponse> call, Response<BayiResponse> response) {
                BayiResponse body = response.body();
                List<BayiData> bayiData = body.getData();

                List<String> nik = new ArrayList<>();
                bayiData.forEach(bayiData1 -> {
                    nik.add(bayiData1.getNik_pasien());
                });
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, nik);

                spinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BayiResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        //Inisialisasi dan Mendapatkan Konteks dari DbBook
        dbhealth = new DbHealth(getActivity().getBaseContext());
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setData();
                int itemPosition = spinner.getSelectedItemPosition();
                String item = spinner.getSelectedItem().toString();
                PostRequestApi requestApi = new PostRequestApi();
                requestApi.setNik(item);
                requestApi.setBerat_badan(Integer.parseInt(beratBadan.getText().toString()));
                requestApi.setLingkar_perut(Integer.parseInt(lingkarPerut.getText().toString()));
                requestApi.setTinggi_badan(Integer.parseInt(tinggiBadan.getText().toString()));
                requestApi.setLab(lab.getText().toString());

                Call<PostResponse> responseCall1 = bayiServiceApi.add(requestApi);
                responseCall1.enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                        Toast.makeText(getContext(), "berhasil menambahkan data" , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<PostResponse> call, Throwable t) {
                        System.out.println(t.getMessage());
                        Toast.makeText(getContext(), "gagal menambahkan data "+t.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });

//                if (){
//
//                    Toast.makeText(getActivity().getApplicationContext(),"Data Kesehatan Belum Lengkap atau Belum diisi, Lengkapi Dahulu!", Toast.LENGTH_SHORT).show();
//                }else {
//
//                    Toast.makeText(getActivity().getApplicationContext(),"Data Kesehatan Tersimpan", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        //intent eksternal untuk masuk kedalam folder atau galeri

        return view;
    }

    //Berisi Statement-Statement Untuk Mendapatkan Input Dari User


    //Berisi Statement-Statement Untuk Menyimpan Data Pada Database






}