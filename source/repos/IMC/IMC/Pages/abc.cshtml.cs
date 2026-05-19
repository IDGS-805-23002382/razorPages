using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace IMC.Pages
{

    public class abcModel : PageModel
    {
        [BindProperty]
        public string texto { get; set; } = "";

        [BindProperty]
        public int n { get; set; } = 3;

        public string resultado { get; set; } = "";

        public void OnGet()
        {

        }

        public void OnPost()
        {
            string abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            texto = texto.ToUpper();

            foreach (char letra in texto)
            {
                // Mantener espacios
                if (letra == ' ')
                {
                    resultado += " ";
                }
                else
                {
                    int posicion = abecedario.IndexOf(letra);

                    // Rotación
                    int nuevaPosicion = (posicion + n) % 26;

                    resultado += abecedario[nuevaPosicion];
                }
            }
        }
    }
}