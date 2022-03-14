using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace project2
{
    
    public partial class Form2 : Form
    {
        string path = @"D:\Project 2\project2\Saves\save.txt";
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            pictureBox1.Image = Image.FromFile(@"D:\Project 2\project2\Fon\fire2.gif");
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            label4.Visible = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {

            if ((textBox2.Text == textBox3.Text) && !(String.IsNullOrEmpty(textBox1.Text)) && !(String.IsNullOrEmpty(textBox2.Text)) && !(String.IsNullOrEmpty(textBox3.Text)))
            {
                using (StreamWriter sw = new StreamWriter(path, true, System.Text.Encoding.Default))
                {
                    sw.WriteLine(textBox1.Text + "\n" + textBox2.Text);
                    sw.Close();

                }

                textBox2.Text = null;
                textBox3.Text = null;
                textBox1.Text = null;
                this.Close();
                Form ifrm = Application.OpenForms[0];           
                ifrm.Show();
                this.Hide();
                label4.Visible = false;
                MessageBox.Show("Регистрация проведена успешно!");

               
            }
            else
            {
                label4.Visible = true;
            }

        }

        private void label4_Click(object sender, EventArgs e)
        {
            
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
