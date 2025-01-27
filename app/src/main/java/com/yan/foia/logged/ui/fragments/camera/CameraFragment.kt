package com.yan.foia.logged.ui.fragments.camera

import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yan.foia.databinding.FragmentCameraBinding
import android.content.ActivityNotFoundException
import android.provider.MediaStore

class CameraFragment : Fragment() {

    private var _binding : FragmentCameraBinding? = null

    private var binding = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root: View = binding.root

        dispatchTakePictureIntent()

        return root
    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

//        startActivity(takePictureIntent)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
//             display error state to the user
        }
    }
}