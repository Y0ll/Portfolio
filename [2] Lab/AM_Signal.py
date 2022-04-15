
import numpy as np
from Generator import Generator

class AM_Signal(Generator): 
    
    
    def __init__(self, f, yn, t, f_dis, a):  
        self.xn = np.arange(0, t, 1 / f_dis)
        self.f = f / 20  
        self.A0 = 2
        self.k = 1
        self.F0 = 10
        self.yn = np.array(yn)
        self.f_dis = f_dis
        self.a = a
       
    
    def get_f(self, const):
        self.f = self.f / const
    
    
    def envelope(self):
        self.save_yn = self.yn
        self.yn = (self.A0 + self.k * self.yn) * np.cos(self.f * self.xn + self.F0 * np.pi)
        return self.yn
    
  
    def generator(self, t): 
        xn = np.arange(self.xn[len(self.xn) - 1], self.xn[len(self.xn) - 1] + t, 1. / self.f_dis)
        
        for i in xn:
            if self.xn[len(self.xn) - 1] + t >= i:
                yield (self.A0 + self.k * self.save_yn) * np.cos(self.f * i + self.F0 * np.pi) 
