package id.deeromptech.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import id.deeromptech.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enterButton.setOnClickListener {
            val enteredText = binding.textInputEditText.text.toString().trim()
            if (enteredText.isNotEmpty()) {
                binding.materialTextView.text = "Hello $enteredText!!"
                binding.textInputEditText.text = null
            } else {
                binding.textInputLayout.error = "Text tidak boleh kosong"
            }
        }

        binding.textInputEditText.addTextChangedListener {
            binding.textInputLayout.error = null
        }
    }

}