import matplotlib.pyplot as plt
from numpy.fft import fft
import numpy as np


class Analyzer():
    
    
    
    def __init__(self, yn, t, f_dis):
        self.f_dis = f_dis
        self.yn = yn
        self.xn = np.arange(0, t, 1. / self.f_dis)
        self.spect = 0
        self.frq = 0
        
    def Graph(self, count):
        self.count = count
        plt.figure(self.count)
        plt.subplot(2, 1, 1)
        plt.plot(self.xn, self.yn)
        plt.show()   

    def Spectr(self):
        y = self.yn
        n = len(y) 
        k = np.arange(n)
        T = n
        frq = k/T 
        frq = frq[range(n//2)] 

        Y = fft(y)/n 
        Y = Y[range(n//2)]
        plt.subplot(2, 1, 2)
        plt.plot(frq,abs(Y),'r') 
        self.spect = Y
 
        self.frq = frq
        
    def Dispersion(self, choice):
        var = np.var(self.yn) 
       
        if choice == 1:
            plt.figure(self.count)
            plt.subplot(2, 1, 1)
            plt.plot(self.xn, var * np.ones(len(self.xn)), label = 'dispersion')
            plt.legend()
        
        return var
        
        
    def Average_Value(self, choice):
        average = sum(self.yn) / len(self.yn) 
       
        
        if choice == 1:
            plt.figure(self.count)
            plt.subplot(2, 1, 1)
            plt.plot(self.xn, average * np.ones(len(self.xn)), label = 'average')
            plt.legend()
        
        return average
        
    
    def Median_Value(self, choice):

        n = len(self.yn)
        index = n // 2

        if n % 2:
            med =  sorted(self.yn)[index]
        else:
            med = sum(sorted(self.yn)[index - 1:index + 1]) / 2
        
        if choice == 1 :
            plt.figure(self.count)
            plt.subplot(2, 1, 1)
            plt.plot(self.xn, med * np.ones(len(self.xn)), label = 'median')
            plt.legend()
        
        return med
    def Max(self, choice):
        maxim = max(self.yn) 
        
        if choice == 1:
            plt.figure(self.count)
            plt.subplot(2, 1, 1)
            plt.plot(self.xn, maxim * np.ones(len(self.xn)), label = 'max')
            plt.legend()
        
        return maxim
    
    def Min(self, choice):
        minim = min(self.yn) 
        
        if choice == 1:
            plt.figure(self.count)
            plt.subplot(2, 1, 1)
            plt.plot(self.xn, minim * np.ones(len(self.xn)), label = 'min')
            plt.legend()
        
        return minim
    
    def Scope(self, choice):
        minim = min(self.yn)
        maxim = max(self.yn)
        
        scope = abs(maxim) + abs(minim)
        
        if choice == 1:
            plt.figure(self.count)
            plt.subplot(2, 1, 1)
            plt.plot(self.xn, scope * np.ones(len(self.xn)), label = 'scope')
            plt.legend()
        
    
    def Reverse_Fourier(self, choice):

        y = np.fft.ifft(self.spect) * 100

        if choice == 1:
           
            plt.figure(self.count + 10)
            plt.subplot(2, 1, 1)
  
            plt.plot(self.frq,  y.real, label = 'real')
            plt.plot(self.frq,  y.imag, '--', label = 'imaginary')
            plt.legend()
            plt.show()
        return y
