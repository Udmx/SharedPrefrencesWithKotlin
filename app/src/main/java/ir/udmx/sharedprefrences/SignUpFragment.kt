package ir.udmx.sharedprefrences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.udmx.sharedprefrences.databinding.FragmentSignupBinding


class SignUpFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    private var userManager: UserManager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        userManager = UserManager(view.context)
        //---------------------------------------------------------------
        /*
        **
        * این قسمت اگر دیتایی وجود داشته باشد را ست میکند
        **
         */
        binding.emailEt.setText(userManager!!.getEmail())
        binding.fullNameEt.setText(userManager!!.getFullName())
        when (userManager!!.getSex()) {
            "MEN" -> binding.sexMenRB.performClick()
            "WOMAN" -> binding.sexWomanRb.performClick()
            "NONE" -> binding.sexNRb.performClick()
        }
        //---------------------------------------------------------------
        binding.saveInfoBtn.setOnClickListener {
            //Method Two
            val radioButtonClicked = when (binding.sexRadioGroup.checkedRadioButtonId) {
                R.id.sexMenRB -> "MEN"
                R.id.sexWomanRb -> "WOMAN"
                R.id.sexNRb -> "NONE"
                else -> ""
            }
            /*
             Method Two
             binding.sexRadioGroup.setOnCheckedChangeListener { radioGroup, id ->  }
            */
            userManager!!.saveUserInformation(
                binding.fullNameEt.text.toString(),
                binding.emailEt.text.toString(),
                radioButtonClicked
            )
        }
    }
}