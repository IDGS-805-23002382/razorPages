using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace IMC.Pages
{

    public class imcModel : PageModel
    {
        [BindProperty]
        public double peso { get; set; }

        [BindProperty]
        public double altura { get; set; }

        public double imc { get; set; }

        public string clasificacion { get; set; } = "";

        public string imagen { get; set; } = "";

        public void OnGet()
        {

        }

        public void OnPost()
        {
            imc = peso / (altura * altura);

            if (imc < 18)
            {
                clasificacion = "Peso Bajo";
                imagen = "/img/bajoPeso.jpg";
            }
            else if (imc >= 18 && imc < 25)
            {
                clasificacion = "Peso Normal";
                imagen = "/img/pesoNormal.jpg";
            }
            else if (imc >= 25 && imc < 27)
            {
                clasificacion = "Sobrepeso";
                imagen = "/img/sobrePeso.jpg";
            }
            else if (imc >= 27 && imc < 30)
            {
                clasificacion = "Obesidad Grado I";
                imagen = "/img/obesidad1.jpg";
            }
            else if (imc >= 30 && imc < 40)
            {
                clasificacion = "Obesidad Grado II";
                imagen = "/img/obesidad2.jpg";
            }
            else
            {
                clasificacion = "Obesidad Grado III";
                imagen = "/img/obesidad3.jpg";
            }
        }
    }
}