using System;
using System.Collections.Generic;
using System.Text;

namespace project2
{
    class  Pers
    {

        public string name;
        public string clas;
        public string voice;
        public int mana;
        public void Info(string n, string cl,string vc,int Mana)
        {
            name = n;
            clas = cl;
            voice = vc;
            Mana = mana;
        
        }
        
        public Pers() { name = "Nameless"; clas = "Empty"; voice = "Empty"; mana = 100;  }
        
    }
}
