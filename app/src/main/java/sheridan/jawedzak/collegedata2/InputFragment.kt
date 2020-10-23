package sheridan.jawedzak.collegedata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import sheridan.jawedzak.collegedata2.databinding.FragmentInputBinding
import sheridan.jawedzak.collegedata2.model.CollegeData

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater,container,false)

        binding.btnSubmit.setOnClickListener { submit() }

        return binding.root
    }

    private fun submit(){

        val studentName = binding.txtStudentName.text.toString()
        var program = ""

        program = if (binding.chkDiploma.isChecked){
            "Diploma"
        }
        else {
            "Degree"
        }

        if (studentName.isNotEmpty() ){
            showOutput(CollegeData(studentName,program))
        }
        else {
            Toast.makeText(this.context, "Student name field is required", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showOutput(cData : CollegeData){
        val action = InputFragmentDirections.actionInputToOutput(cData)
        findNavController().navigate(action)
    }
}