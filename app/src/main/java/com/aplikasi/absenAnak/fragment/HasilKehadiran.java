package com.aplikasi.absenAnak.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplikasi.absenAnak.R;
import com.aplikasi.absenAnak.databinding.FragmentHasilBinding;
import com.aplikasi.absenAnak.models.Waktu;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HasilKehadiran extends Fragment {

    public static final String MHS_REQUEST_KEY = "anak";
    public static final String DS_REQUEST_KEY = "guru";
    public static final String JUMLAH_KEY = "jumlah";

    private List<Waktu> anakWaktuList;
    private List<Waktu> guruWaktuList;

    public HasilKehadiran() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.anakWaktuList = new ArrayList<>();
        this.guruWaktuList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHasilBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_hasil, container, false);
        binding.setFragment(this);
        binding.setAnakWaktuList(anakWaktuList);
        binding.setGuruWaktuList(guruWaktuList);
        getParentFragmentManager().setFragmentResultListener(MHS_REQUEST_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Waktu waktu = result.getParcelable(JUMLAH_KEY);
                anakWaktuList.add(waktu);
            }
        });

        getParentFragmentManager().setFragmentResultListener(DS_REQUEST_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Waktu waktu = result.getParcelable(JUMLAH_KEY);
                guruWaktuList.add(waktu);
            }
        });

        return binding.getRoot();
    }

    public String anak(){
        StringBuilder builder = new StringBuilder();
        for (Waktu waktu : anakWaktuList){
            builder.append("nama : ")
                    .append(waktu.getName())
                    .append("\r")
                    .append("Hari : ")
                    .append(waktu.getHari())
                    .append("\r")
                    .append("Keterangan : ")
                    .append(waktu.getStatus())
                    .append("\n");
        }
        return builder.toString();
    }

    public String guru(){
        StringBuilder builder = new StringBuilder();
        for (Waktu waktu : guruWaktuList){
            builder.append("nama : ")
                    .append(waktu.getName())
                    .append("\r")
                    .append("Hari : ")
                    .append(waktu.getHari())
                    .append("\r")
                    .append("Keterangan : ")
                    .append(waktu.getStatus())
                    .append("\n");
        }
        return builder.toString();
    }

    public void onAddHomeClick(View view) {
        HasilDirections action;
        action = HasilDirections.actionHasilToAbsen(MHS_REQUEST_KEY);
        Navigation.findNavController(view).navigate(action);
    }

    public void onAddAwayClick(View view) {
        HasilDirections action = HasilDirections.actionHasilToAbsen(DS_REQUEST_KEY);
        Navigation.findNavController(view).navigate(action);
    }
}