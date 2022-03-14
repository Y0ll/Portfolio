using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Media;
using WMPLib;
using Microsoft.Win32;

namespace project2
{
    public partial class Form3 : Form
    {
        Pers pers = new Pers();
        bool choiceclass = false;
        bool choicevoice = false;
        WMPLib.WindowsMediaPlayer sp = new WMPLib.WindowsMediaPlayer();
        WMPLib.WindowsMediaPlayer wp = new WMPLib.WindowsMediaPlayer();
        WMPLib.WindowsMediaPlayer voice = new WMPLib.WindowsMediaPlayer();
        bool mage = false;
        bool war = false;
        bool hunt = false;
        bool voiceone = false;
        bool voicetwo = false;
        bool voicethree = false;
        string sound_filename = @"D:\Project 2\project2\music\MainTheme.mp3";
        string choice= @"D:\Project 2\project2\music\choice.mp3";
        string exit= @"D:\Project 2\project2\music\exit.mp3";
        public Form3()
        {
            InitializeComponent();
           
        }
     
        private void button1_Click(object sender, EventArgs e)
        {
            wp.URL = exit;
            wp.settings.volume = 50;
            wp.controls.play();
            sp.controls.stop();
            Form ifrm = Application.OpenForms[0];
            //ifrm.Show();
            //this.Hide();
            Application.Exit();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            label13.Visible = false;
            //SoundPlayer sp = new SoundPlayer();
            sp.URL= sound_filename;
            sp.settings.volume = 50;
            sp.controls.play();
            // this.Cursor = new Cursor(@"D:\Project 2\project2\Cursor\curs1.cur");
           


        }

        
        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            choiceclass = true;
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            pictureBox1.Image = null;
            
            mage = false;
            hunt = false;
            war = true;

            pictureBox1.Image = Image.FromFile(@"D:\Project 2\project2\Character\war9.gif");
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            label8.Text = "5";
            label16.Text = "1";
            label10.Text = "3";
            label11.Text = "1";


            pictureBox2.Image = Image.FromFile(@"D:\Project 2\project2\skills\voin\attack.PNG");
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox3.Image = Image.FromFile(@"D:\Project 2\project2\skills\voin\sheet.PNG");
            pictureBox3.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox4.Image = Image.FromFile(@"D:\Project 2\project2\skills\voin\shlem.PNG");
            pictureBox4.SizeMode = PictureBoxSizeMode.StretchImage;


           
            toolTip1.SetToolTip(this.pictureBox2, "Attack - способность, наносящая урон противнику.");
            toolTip1.SetToolTip(this.pictureBox3, "Shield - пассивная способность, дающая 1 дополнительную жизнь после смерти.");
            toolTip1.SetToolTip(this.pictureBox4, "Smach - способность, наносящая урон вокруг себя во всей области.");

            label9.Text = " Воин - Профессиональный боец, \n \n лишенный способностей \n \n к магии, но \n \n компенсирующий это виртуозным \n \n владением оружием и \n \n незаурядными физическими \n \n данными.";


          

        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            choiceclass = true;
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            pictureBox1.Image = null;
            mage = true;
            hunt = false;
            war = false;


            pictureBox1.Image = Image.FromFile(@"D:\Project 2\project2\Character\Mag.gif");
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            label8.Text = "1";
            label16.Text = "2";
            label10.Text = "1";
            label11.Text = "6";
            pictureBox2.Image = Image.FromFile(@"D:\Project 2\project2\skills\mage\fireball.PNG");
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox3.Image = Image.FromFile(@"D:\Project 2\project2\skills\mage\meteor.PNG");
            pictureBox3.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox4.Image = Image.FromFile(@"D:\Project 2\project2\skills\mage\speed.PNG");
            pictureBox4.SizeMode = PictureBoxSizeMode.StretchImage;
            toolTip1.SetToolTip(this.pictureBox2, "Fireball - способность, наносящая противнику урон.");
            toolTip1.SetToolTip(this.pictureBox3, "FireRing - спобосность, призывающая кольцо огня.");
            toolTip1.SetToolTip(this.pictureBox4, "Freezing blood - пассивная способность повышающая стартовую ману в два раза. ");
            label9.Text = " Маг - это человек, \n \n который умеет воздействовать\n \n своим волшебством на природу,\n \n любые объекты материального\n \n или нематериального мира\n \n и других людей с помощью\n \n различных духов и всевозможных\n \n энергий созданных Богом \n \n и идущих от него, \n \n мира джиннов и т. д. и т. п.";
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {
            choiceclass = true;
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            mage = false;
            hunt = true;
            war = false;
            pictureBox1.Image = null;
            pictureBox1.Image = Image.FromFile(@"D:\Project 2\project2\Character\hunt.gif");
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            label8.Text = "2";
            label16.Text = "4";
            label10.Text = "2";
            label11.Text = "2";
            pictureBox2.Image = Image.FromFile(@"D:\Project 2\project2\skills\hunt\attack2.PNG");
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox3.Image = Image.FromFile(@"D:\Project 2\project2\skills\hunt\grad2.PNG");
            pictureBox3.SizeMode = PictureBoxSizeMode.StretchImage;
            pictureBox4.Image = Image.FromFile(@"D:\Project 2\project2\skills\hunt\dozh2.PNG");
            pictureBox4.SizeMode = PictureBoxSizeMode.StretchImage;
            toolTip1.SetToolTip(this.pictureBox2, "Attack - способность, наносящая противнику урон.");
            toolTip1.SetToolTip(this.pictureBox4, "Volley - способность, призывающая залп стрел вокруг себя .");
            toolTip1.SetToolTip(this.pictureBox3, "Chrono shift - пассивная способность, немного замедляющее время.");
            label9.Text = " Охотник: Стрелок,\n \n использующий в бою стрелковое\n \n орудие. Невероятно слаб\n \n в ближнем бою.\n \n Стрелку доступны все виды\n \n стрелкового орудия,\n \n от луков и арбалетов,\n \n до пращи и дротиков.";
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void label9_Click(object sender, EventArgs e)
        {

        }

        private void label11_Click(object sender, EventArgs e)
        {

        }

        private void label10_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {

        }

        private void toolTip1_Popup(object sender, PopupEventArgs e)
        {

        }

        private void toolTip1_Popup_1(object sender, PopupEventArgs e)
        {

        }

        private void voice2_CheckedChanged(object sender, EventArgs e)
        {
            choicevoice = true;
            voiceone = false;
            voicetwo = true;
            voicethree = false;
            if (mage == true)
            {
                voice.URL = @"D:\Project 2\project2\Voice\Маг 3.wav";
                voice.settings.volume = 50;
                voice.controls.play();
            }
            if (hunt == true)
            {

                voice.URL = @"D:\Project 2\project2\Voice\Лучник.wav";
                voice.settings.volume = 50;
                voice.controls.play();

            }
            if (war == true)
            {

                voice.URL = @"D:\Project 2\project2\Voice\Воин 2.wav";
                voice.settings.volume = 50;
                voice.controls.play();

            }
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
        }

        private void voice3_CheckedChanged(object sender, EventArgs e)
        {
            choicevoice = true;
            voiceone = false;
            voicetwo = false;
            voicethree = true;
            if (mage == true)
            {
                voice.URL = @"D:\Project 2\project2\Voice\mag3.mp3";
                voice.settings.volume = 50;
                voice.controls.play();
            }
            if (hunt == true)
            {

                voice.URL = @"D:\Project 2\project2\Voice\Hunt3.m4a";
                voice.settings.volume = 50;
                voice.controls.play();

            }
            if (war == true)
            {

                voice.URL = @"D:\Project 2\project2\Voice\war3.mp3";
                voice.settings.volume = 50;
                voice.controls.play();

            }
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            sp.settings.volume = 0;
        }

        private void radioButton5_CheckedChanged(object sender, EventArgs e)
        {
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            sp.settings.volume = 25;
        }

        private void radioButton6_CheckedChanged(object sender, EventArgs e)
        {
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            sp.settings.volume = 50;
        }

        private void radioButton7_CheckedChanged(object sender, EventArgs e)
        {
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            sp.settings.volume = 75;
        }

        private void radioButton8_CheckedChanged(object sender, EventArgs e)
        {
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
            sp.settings.volume = 100;
        }

        private void voice1_CheckedChanged(object sender, EventArgs e)
        {
            choicevoice = true;
            voiceone = true;
            voicetwo = false;
            voicethree = false;
            if (mage == true) {
                voice.URL = @"D:\Project 2\project2\Voice\mag1.aac";
                voice.settings.volume = 50;
                voice.controls.play();
            }
            if (hunt == true)
            {
                
                    voice.URL = @"D:\Project 2\project2\Voice\Hunt1.aac";
                    voice.settings.volume = 50;
                    voice.controls.play();
                
            }
            if (war == true)
            {
                
                    voice.URL = @"D:\Project 2\project2\Voice\war1.aac";
                    voice.settings.volume = 50;
                    voice.controls.play();
                
            }
            wp.settings.volume = 50;
            wp.controls.play();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            label13.Visible = false;
            if ((choicevoice == true) && (choiceclass == true) && (textBox1.Text != ""))
            {
                string clas = "0";
                string voice = "0";
                int man = 100;
                if (mage == true) { clas = null; clas = "Mage"; }
                if (hunt == true) { clas = null; clas = "Hunter"; }
                if (war == true) { clas = null; clas = "Warrior"; }
                if (voiceone == true) { voice = null; voice = "Voice 1"; };
                if (voicetwo == true) { voice = null; voice = "Voice 2"; };
                if (voicethree == true) { voice = null; voice = "Voice 3"; };
                pers.Info(textBox1.Text, clas, voice, man);
                wp.URL = exit;
                wp.settings.volume = 50;
                wp.controls.play();
                sp.controls.stop();
                string n = pers.name;
                Form4 game = new Form4();
                game.label1.Text = pers.name;
                game.label2.Text = pers.clas;
                game.label3.Text = 100.ToString(); //pers.mana.ToString();
                game.label4.Text = pers.voice;



                game.Show();
                this.Hide();
            }
            else { label13.Visible = true; }
        }
       

        private void textBox1_MouseClick(object sender, MouseEventArgs e)
        {
            wp.URL = choice;
            wp.settings.volume = 50;
            wp.controls.play();
        }

        private void Form3_CursorChanged(object sender, EventArgs e)
        {
            
        }

        private void label13_Click(object sender, EventArgs e)
        {

        }
    }
}
