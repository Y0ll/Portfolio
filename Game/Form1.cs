using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using Microsoft.Win32;

namespace project2
{
    public partial class Form1 : Form
    {
        
        Form2 registr = new Form2();
        Form3 Main = new Form3();
        List<Profile> list = new List<Profile>();
        string path = @"D:\Project 2\project2\Saves\save.txt";
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            label3.Visible = false ;
            pictureBox1.Image = Image.FromFile(@"D:\Project 2\project2\Fon\fire.gif");
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;


        }
        
        private void button2_Click(object sender, EventArgs e)
        {
            label3.Visible = false; ;
            registr.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            label3.Visible = false;

            int k = 0;
            bool enter = false;
            using (StreamReader sr = new StreamReader(path, System.Text.Encoding.Default))
            {
                string line;

                
                while ((line = sr.ReadLine()) != null)
                {
                    
                    if ((k % 2) == 0)
                    {
                        list.Insert(k, new Profile() { name = line });
                        
                    }
                    else { list.Insert(k, new Profile() { password = line });}
                    k++;
                    
                }
            }
            
            for (int i = 0; i < k; i = (i + 2)) {
        
                if ((textBox1.Text != null) && (textBox2.Text != null) && (textBox1.Text == list[i].name.ToString()) && (textBox2.Text==list[i+1].password.ToString())) {
                    Main.Show();
                    enter = true;
                    i = 0;
                    this.Hide();
                    break;
                }
            }
            if (enter != true) { label3.Visible = true; }
            textBox1.Text = null;
            textBox2.Text = null;
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }
    }
}
