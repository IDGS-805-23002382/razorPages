using Microsoft.AspNetCore.Mvc.RazorPages;

namespace IMC.Pages
{

    public class arregloModel : PageModel
    {
        public int[] numeros { get; set; }

        public int[] ordenados { get; set; }

        public int suma { get; set; }

        public double promedio { get; set; }

        public double mediana { get; set; }

        public string moda { get; set; }


        public void OnGet()
        {
            Random random = new Random();

            numeros = new int[20];

            // GENERAR NUMEROS ALEATORIOS
            for (int i = 0; i < numeros.Length; i++)
            {
                numeros[i] = random.Next(0, 101);
            }

            // SUMA
            suma = numeros.Sum();

            // PROMEDIO
            promedio = numeros.Average();

            // ORDENAR
            ordenados = numeros.OrderBy(x => x).ToArray();

            // MEDIANA
            mediana = (ordenados[9] + ordenados[10]) / 2.0;

            // MODA
            var grupos = numeros
                .GroupBy(x => x)
                .OrderByDescending(g => g.Count());

            int maxRepeticiones = grupos.First().Count();

            var modas = grupos
                .Where(g => g.Count() == maxRepeticiones && maxRepeticiones > 1)
                .Select(g => g.Key);

            moda = modas.Any()
                ? string.Join(" y ", modas)
                : "No hay moda";
        }
    }
}