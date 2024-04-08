from matplotlib import pyplot as plt
from math import pi, cos, sin

PI = pi

CNT = 1024

X = [PI * ((2 * x / CNT) - 1) for x in range(CNT)]
C = [cos(x) for x in X]
S = [sin(x) for x in X]

# plt.plot(X, C)
# plt.plot(X, S)

plt.figure(figsize=(10, 6), dpi=80)
plt.plot(X, C, color="blue", linewidth=2.5, linestyle="-", label="cosine")
plt.plot(X, S, color="red", linewidth=2.5, linestyle="-", label="sine")

"""
Limits for the plot
"""
plt.xlim(min(X) * 1.1, max(X) * 1.1)
plt.ylim(min(C) * 1.1, max(C) * 1.1)

"""
Show specific points
"""
plt.xticks([-PI, -PI / 2, 0, PI / 2, PI], [r'$-\pi$', r'$-\pi/2$', r'$0$', r'$+\pi/2$', r'$+\pi$'])
plt.yticks([-1, 0, 1], [r'$-1$', r'$0$', r'$+1$'])

"""
Legend
"""
plt.legend(loc="upper left", frameon=False)

"""
GCA = GetCurrentAxes
"""
ax = plt.gca()
ax.spines['right'].set_color('none')
ax.spines['top'].set_color('none')
ax.spines['bottom'].set_position(('data', 0))
ax.spines['left'].set_position(('data', 0))

t = 2 * PI / 3
plt.plot([t, t], [0, cos(t)], color='blue', linewidth=2.5, linestyle="--")
plt.scatter([t, ], [cos(t), ], 50, color='blue')
plt.annotate(r'$\sin(\frac{2\pi}{3})=\frac{\sqrt{3}}{2}$',
             xy=(t, sin(t)), xycoords='data',
             xytext=(+10, +30), textcoords='offset points', fontsize=16,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))
plt.plot([t, t], [0, sin(t)], color='red', linewidth=2.5, linestyle="--")
plt.scatter([t, ], [sin(t), ], 50, color='red')
plt.annotate(r'$\cos(\frac{2\pi}{3})=-\frac{1}{2}$',
             xy=(t, cos(t)), xycoords='data',
             xytext=(-90, -50), textcoords='offset points', fontsize=16,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))

t = -PI / 4

# Fontsize ändern
for label in ax.get_xticklabels() + ax.get_yticklabels():
    label.set_fontsize(13)

plt.title("Maxis Grafik")
plt.savefig("plot1_kniely.png", dpi=80)
plt.show()
