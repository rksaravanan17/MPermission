/*
 *
 *  Copyright 2018 Muthukrishnan R
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.rmkrishna.mpermission

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.rmkrishna.permission.MPermission
import com.rmkrishna.permission.askPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        askContactPermission.setOnClickListener {
            askPermissions(MPermission.WRITE_CONTACTS) {
                granted {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission granted Success!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                denied {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission Denied by user",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                neverAskAgain {
                    Toast.makeText(
                        this@MainActivity,
                        "Don't ask this permission, Pleaseeee",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        askMultiplePermission.setOnClickListener {
            askPermissions(
                MPermission.WRITE_EXTERNAL_STORAGE,
                MPermission.READ_EXTERNAL_STORAGE,
                MPermission.CAMERA
            ) {
                granted {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission granted Success!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                denied {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission Denied by user",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                neverAskAgain {
                    Toast.makeText(
                        this@MainActivity,
                        "Don't ask this permission, Pleaseeee",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        openJavaActivity.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    MainJavaActivity::class.java
                )
            )
        }
        openFragmentSupportActivity.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    FragmentSupportActivity::class.java
                )
            )
        }
    }
}
