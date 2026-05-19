using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace IMC.Pages
{

    public class evaluarExpresionModel : PageModel
    {

        [BindProperty]
        public int a { get; set; }

        [BindProperty]
        public int b { get; set; }

        [BindProperty]
        public int x { get; set; }

        [BindProperty]
        public int y { get; set; }

        [BindProperty]
        public int n { get; set; }

        public double resultado { get; set; }

        public List<string> pasos { get; set; } = new List<string>();


        public void OnGet()
        {

        }

        public void OnPost()
        {
            resultado = 0;

            for (int k = 0; k <= n; k++)
            {
                double combinacion = Factorial(n) /
                                    (Factorial(k) * Factorial(n - k));

                double termino1 = Math.Pow((a * x), (n - k));

                double termino2 = Math.Pow((b * y), k);

                double parcial = combinacion * termino1 * termino2;

                resultado += parcial;

                pasos.Add(
                    $"k={k} → ({combinacion}) * ({termino1}) * ({termino2}) = {parcial}"
                );
            }
        }


        public double Factorial(int numero)
        {
            double fact = 1;

            for (int i = 1; i <= numero; i++)
            {
                fact *= i;
            }

            return fact;
        }
    }
}