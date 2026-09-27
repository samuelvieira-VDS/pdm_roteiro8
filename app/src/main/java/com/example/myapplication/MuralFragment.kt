package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.FragmentMuralBinding

class MuralFragment : Fragment() {

    private var _binding: FragmentMuralBinding? = null

    private val binding
        get() = _binding!!

    private val viewModel: MuralViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMuralBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.post.observe(viewLifecycleOwner) { post ->

            binding.textTitulo.text = post.titulo
            binding.textMensagem.text = post.mensagem
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}