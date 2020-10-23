package sheridan.jawedzak.collegedata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.jawedzak.collegedata2.databinding.FragmentOutputBinding
import sheridan.jawedzak.collegedata2.model.CollegeData
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OutputFragment : Fragment() {
    private lateinit var binding : FragmentOutputBinding
    private lateinit var cData : CollegeData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(inflater,container,false)

        //get parameters from safe args or bundle
        cData =
                if (savedInstanceState is Bundle){
                    savedInstanceState.getSerializable("college_data") as CollegeData
                }else{
                    val safeargs: OutputFragmentArgs by navArgs()
                    safeargs.cData
                }

        binding.lblStudentNme.text = cData.stuName
        binding.lblProgram.text = cData.program


        binding.btnBack.setOnClickListener { goBack() }
        return binding.root
    }

    private fun goBack(){
        val action = OutputFragmentDirections.actionOutputToInput()
        findNavController().navigate(action)
    }
}