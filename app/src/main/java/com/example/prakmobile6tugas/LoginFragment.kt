package com.example.prakmobile6tugas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    class TabAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> LoginFragment.newInstance()
                1 -> RegisterFragment.newInstance("","")
                else -> throw IllegalArgumentException("Invalid tab position")
            }
        }
        override fun getCount(): Int {
            return 2
        }
        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Login"
                1 -> "Register"
                else -> null
            }
        }
    }

    class LoginFragment : Fragment() {

        private lateinit var etUsername: EditText
        private lateinit var etPassword: EditText
        private lateinit var btnLogin: Button

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_login, container, false)

            etUsername = view.findViewById(R.id.username)
            etPassword = view.findViewById(R.id.password)
            btnLogin = view.findViewById(R.id.login)

            btnLogin.setOnClickListener {
                val username = etUsername.text.toString()
                Log.d("username", username)
                val password = etPassword.text.toString()
                Log.d("password", password)

                // Place your login logic here
                // Example logic:
                if (username == "arviansyah" && password == "kur"){
                    val intenttodashboard =
                        Intent(requireContext(), Dashboard::class.java)
                    startActivity(intenttodashboard)
                    intenttodashboard.putExtra("username", username)
                } else {
                    Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }

            return view
        }

        companion object {
            @JvmStatic
            fun newInstance() = LoginFragment()
        }
    }

}
