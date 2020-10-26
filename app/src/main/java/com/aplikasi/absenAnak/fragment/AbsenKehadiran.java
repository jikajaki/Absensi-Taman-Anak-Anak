package com.aplikasi.absenAnak.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplikasi.absenAnak.R;
import com.aplikasi.absenAnak.databinding.FragmentAbsenBinding;
import com.aplikasi.absenAnak.models.Waktu;

/**
 * A simple {@link Fragment} subclass.
 */
public class AbsenKehadiran extends Fragment {

    private String requestKey;
    private Waktu waktu;

    public AbsenKehadiran() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.waktu = new Waktu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAbsenBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_absen, container, false);
        binding.setFragment(this);
        binding.setWaktu(waktu);
        requestKey = AbsenKehadiranArgs.fromBundle(getArguments()).getRequestKey();
        return binding.getRoot();
    }

    private String getRequestKey() {
    }

    public void onSaveClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(HasilKehadiran.JUMLAH_KEY, waktu);
        getParentFragmentManager().setFragmentResult(requestKey, bundle);
        Navigation.findNavController(view).navigateUp();
    }

    public void onCancelClicked(View view) {
        Navigation.findNavController(view).navigateUp();
    }
}