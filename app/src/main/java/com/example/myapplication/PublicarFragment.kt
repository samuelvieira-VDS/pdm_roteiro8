package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.FragmentPublicarBinding

class PublicarFragment : Fragment() {

    private var _binding: FragmentPublicarBinding? = null

    private val binding
        get() = _binding!!

    private val viewModel: MuralViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPublicarBinding.inflate(
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

        binding.btnEnviar.setOnClickListener {

            val titulo = binding.editTitulo.text.toString()
            val mensagem = binding.editMensagem.text.toString()

            if (titulo.isBlank() || mensagem.isBlank()) {

                Toast.makeText(
                    requireContext(),
                    "Preencha todos os campos",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                viewModel.publicar(
                    titulo,
                    mensagem
                )

                Toast.makeText(
                    requireContext(),
                    "Publicado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                parentFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.fragmentContainer,
                        MuralFragment()
                    )
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}