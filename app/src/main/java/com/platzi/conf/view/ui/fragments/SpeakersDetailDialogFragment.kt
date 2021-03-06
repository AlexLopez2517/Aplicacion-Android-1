package com.platzi.conf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.platzi.conf.R
import com.platzi.conf.model.Speaker
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class SpeakersDetailDialogFragment : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarSpeaker.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarSpeaker.setNavigationOnClickListener {
            dismiss()
        }

        val  speaker = arguments?.getSerializable("speaker") as Speaker
        toolbarSpeaker.title = speaker.name

        tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerWorkplace.text = speaker.jobtitle
        tvDetailSpeakerBiography.text = speaker.biography
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}