package com.example.myo_jib_sa.mission.Dialog

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.myo_jib_sa.databinding.DialogMissionReportFragmentBinding


class MissionReportDialogFragment : DialogFragment() {
    private lateinit var binding: DialogMissionReportFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogMissionReportFragmentBinding.inflate(inflater, container, false)

        binding.dialogExitBtn.setOnClickListener {
            dismiss()
        }

        binding.reportCheckTxt.setOnClickListener {
            // 신고 api 연결 로직
            dismiss()
        }

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return dialog
    }

    override fun onResume() {
        super.onResume()
        // 다이얼로그의 크기 설정
        dialog?.let { setDialogSize(it, 0.8, WindowManager.LayoutParams.WRAP_CONTENT) }
    }

    private fun setDialogSize(dialog: Dialog, widthPercentage: Double, height: Int) {
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window?.attributes)

        val displayMetrics = resources.displayMetrics
        val dialogWidth = (displayMetrics.widthPixels * widthPercentage).toInt()
        layoutParams.width = dialogWidth
        layoutParams.height = height

        dialog.window?.attributes = layoutParams
    }
}

