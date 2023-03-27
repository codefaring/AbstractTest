package com.example.abstracttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.abstracttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        abstract class Animal {
            fun eat(): String {
                return "먹습니다"
            }
            abstract fun move(): String
        }

        class Fish: Animal() {
            override fun move(): String {
                return "헤엄칩니다"
            }
        }

        var fish = Fish()

        Log.d("Fish", "${fish.eat()}")

        Log.d("Fish", "${fish.move()}")

        class TestImpl: TestKotlin {
            override var str: String = "Hi Impt"
            override fun sum(num1: Int, num2: Int): Int {
                return num1 + num2
            }

            override fun view() {
                Log.d("TestImpl fun view", "인터페이스 테스트")
            }
        }

        // 실무에서 더 많이 사용한다고 함.
        var testObj = object: TestKotlin {
            override var str: String = "Hi Obj"
            override fun sum(num1: Int, num2: Int): Int {
                return num1 + num2
            }

            override fun view() {
                Log.d("testObj fun view", "인터페이스 테스트")
            }
        }

        var testImpl = TestImpl()
        testImpl.view()

        testObj.view()
        Log.d("testObj.sum(40, 2)", "${testObj.sum(40, 2)}")
        Log.d("testObj.str", "${testObj.str}")


        var showUp = ActivityMainBinding.inflate(layoutInflater)
        setContentView(showUp.root)

        showUp.btn.setOnClickListener {
            showUp.show.text = "${testImpl.sum(5, 10)}"
        }


    }
}