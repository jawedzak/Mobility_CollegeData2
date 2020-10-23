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
    private val safeArgs: OutputFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOutputBinding.inflate(inflater, container, false)
        with(safeArgs.cData){
            binding.lblStudentNme.text = stuName
            binding.lblProgram.text = program
        }
        binding.btnBack.setOnClickListener { goBack() }
        return binding.root
    }

    private fun goBack(){
        val action = OutputFragmentDirections.actionOutputToInput()
        findNavController().navigate(action)
    }
}