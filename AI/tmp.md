$@ H(x) = \begin{cases} 0 &amp; \text{if } x < 0 \\1 & \text{if } x \geq 0\end{cases} @$
$@ \tanh(x) = \frac{e^x - e^{-x}}{e^x + e^{-x}} @$
$@ \sigma(x) = \frac{1}{1 + e^{-x}} $$
$@ \text{softmax}(x*i) = \frac{e^{x_i}}{\sum*{j} e^{x*j}} = \frac{e^{x_i - \max(x)}}{\sum*{j} e^{x_j - \max(x)}} @$
$@ \text{ReLU}(x) = \max(0, x) @$
$@ \text{Leaky ReLU}(x) = \begin{cases}       x & x > 0 \\      0.01x & x \leq 0    \end{cases} @$
